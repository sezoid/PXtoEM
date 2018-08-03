import React, { Component } from 'react';

import Card from './components/Card';
import Converter from './components/Converter/index';
import Download from './components/Download/index';
import Titlebar from './components/Titlebar';

import * as config from './config.json';
import './App.css';

class App extends Component {
	state = config;

	onFocus = event => {
		event.target.select();
	};

	onChangeBase = event => {
		const input = event.target;

		this.setState({
			base: input.value.replace(/[^0-9.]/g, '')
		});
	};

	onChangePX = event => {
		const input = event.target;
		const {base} = this.state;

		this.setState({
			px: input.value.replace(/[^0-9.]/g, ''),
			em: input.value.replace(/[^0-9.]/g, '') / base
		});
	};

	onChangeEM = event => {
		const input = event.target;
		const {base} = this.state;

		this.setState({
			em: input.value.replace(/[^0-9.]/g, ''),
			px: input.value.replace(/[^0-9.]/g, '') * base
		});
	};

	onSubmit = event => {
		event.preventDefault();
	};

	render() {
		const {base, em, px, titlebar, download} = this.state;

		return (
			<div className='App'>
				<Titlebar state={titlebar} />
				<main>
					<Card title='Конвертер'>
						<Converter base={base}
							em={em}
							onFocus={this.onFocus}
							onChange={[this.onChangeBase, this.onChangePX, this.onChangeEM]}
							onSubmit={this.onSubmit}
							px={px} />
					</Card>
					<Card title='Загрузки'>
						<Download links={download} />
					</Card>
				</main>
			</div>
		);
	};
};

export default App;
