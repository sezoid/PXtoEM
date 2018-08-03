import React from 'react';
import {CopyToClipboard} from 'react-copy-to-clipboard';

const Input = props => (
	<div className='Input'>
		<div className='Info'>
			<label htmlFor={props.id}>{props.label}</label>
			<CopyToClipboard text={props.value}>
				<span className='Copy'>Копировать</span>
			</CopyToClipboard>
		</div>
		<input
			autoComplete={props.autoComplete}
			id={props.id}
			onChange={props.onChange}
			onFocus={props.onFocus}
			placeholder={props.placeholder}
			type='text'
			value={props.value}
		/>
	</div>
);

export default Input;
