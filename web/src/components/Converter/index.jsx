import React from 'react';

import './index.css';
import Input from './Input';

const Converter = props => (
	<form className='Converter' onSubmit={props.onSubmit}>
		<Input
			autoComplete='off'
			id='base'
			label='Базовое значение'
			onChange={props.onChange[0]}
			onFocus={props.onFocus}
			placeholder='Введите базовое значение (16px - по умолчанию)'
			value={props.base}
		/>
		<Input
			autoComplete='off'
			id='px'
			label='PX'
			onChange={props.onChange[1]}
			onFocus={props.onFocus}
			placeholder='Введите число PX'
			value={`${props.px}px`}
		/>
		<Input
			autoComplete='off'
			id='em'
			label='EM'
			onChange={props.onChange[2]}
			onFocus={props.onFocus}
			placeholder='Введите число EM'
			value={`${props.em}em`}
		/>
	</form>
);

export default Converter;
