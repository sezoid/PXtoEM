import React from 'react';

const Nav = props => (
	<nav className='Nav'>
		{props.links.map(item => (
			<a href={item.url} key={item.id}>{item.title}</a>
		))}
	</nav>
);

export default Nav;
