var Product = React.createClass({
  getInitialState: function() {
    return {
      quantity: 1
    };
  },
  
  updateQuantity: function(evt) {
	this.setState({
		quantity: evt.target.value
	});
  },
  
  addToCart: function() {
    fetch('/cart/item', {
      credentials: 'same-origin',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        id: this.props.product.id,
        quantity: this.state.quantity,
     })
    });
  },

  render: function() {
    var name = this.props.product.name;
    var id = this.props.product.id;
    var price = this.props.product.price;

    return (
      <div className="col-sm-3">
        <div className="col-item">
          <div className="photo">
            <img src="http://placehold.it/200x210/fullstack/frontend/images/chair" className="img-responsive" alt="a" />
            {/*<img src ="/fullstack/frontend/images/chair.jpg" className="img-responsive" />*/}
          </div>
          <div className="info">
            <div className="row">
              <div className="price col-md-12">
                <h5>{name}</h5>
                <h5 className="price-text-color">${price}</h5>
              </div>
            </div>
            <div className="separator clear-left">
              <p className="section-qty">
                <input className="form-control input-sm" type="text" value={this.state.quantity} onChange={this.updateQuantity} />
              </p>
              <p className="section-add">
                <button type="button" className="btn btn-link btn-xs" onClick={this.addToCart}>
                  <i className="fa fa-shopping-cart"></i><span className="hidden-sm">Add to cart</span>
                </button>
              </p>
            </div>
            <div className="clearfix"></div>
          </div>
        </div>
      </div>
    );
  }
});