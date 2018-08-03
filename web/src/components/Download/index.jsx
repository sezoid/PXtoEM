import React from 'react';

const Download = props => (
	<div className='Download' id='download'>
		<p>PXtoEM - простой конвертер, позволяющий с легкостью конвертировать размеры элементов страниц из PX в EM и обратно.</p>
		<div className='buttons'>
			{props.links.map(item => (
				<a href={item.url} key={item.id}>{item.title}</a>
			))}
		</div>
	</div>
);

export default Download;
