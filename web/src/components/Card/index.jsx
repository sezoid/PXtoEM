import React from 'react';

import './index.css';

const Card = props => (
	<div className='Card'>
		<h1>{props.title}</h1>
		<div className='Content'>{props.children}</div>
	</div>
);

export default Card;
