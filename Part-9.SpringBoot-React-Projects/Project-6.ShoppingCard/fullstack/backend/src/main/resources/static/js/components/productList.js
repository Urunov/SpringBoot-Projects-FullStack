var ProductList = React.createClass({
  render: function() {

    var productsMapped = this.props.products.map(function (product, index) {
      return <Product product={product} key={index} />
    });

    return ( <div className="row extra-bottom-margin"> {productsMapped} </div> );
  }
});