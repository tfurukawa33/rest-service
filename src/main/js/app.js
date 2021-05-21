const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
		super(props);
		this.state = {suppliers: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/suppliers'}).done(response => {
			this.setState({suppliers: response.entity});
		});
	}

	render() {
		return (
			<SupplierList suppliers={this.state.suppliers}/>
		)
	}
}

class SupplierList extends React.Component{
	render() {
		const suppliers = this.props.suppliers.map(supplier =>
			<Supplier key={supplier.id} supplier={supplier}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Group</th>
					</tr>
					{suppliers}
				</tbody>
			</table>
		)
	}
}

class Supplier extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.supplier.id}</td>
				<td>{this.props.supplier.name}</td>
				<td>{this.props.supplier.group.name}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)