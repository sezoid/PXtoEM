import React from 'react';

import Nav from './Nav';

import './index.css';
import Logo from './Logo';

const Titlebar = props => {
	const {state} = props;

	return (
		<header className='Titlebar'>
			<Logo image={state.logo} />
			<Nav links={state.links} />
		</header>
	);
}

export default Titlebar;
