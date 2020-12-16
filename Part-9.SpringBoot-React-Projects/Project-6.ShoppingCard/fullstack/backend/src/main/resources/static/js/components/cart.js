var Cart = React.createClass({
  emptyCart: function() {
    fetch('/cart', {
      credentials: 'same-origin',
      method: 'DELETE'
    });
  },
	  
  render: function() {
    var itemsMapped = this.props.items.map(function (item, index) {
      return <CartItem item={item} key={index} />
    });
    
    var empty = <div className="alert alert-info">Cart is empty</div>;

    return (
      <div className="row extra-bottom-margin">
        <div className="col-xs-8 col-xs-offset-2">
          <div className="panel panel-info">
            <div className="panel-heading">
              <div className="panel-title">
				<div className="row">
                  <div className="col-xs-12">
                    <h5><span className="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
                  </div>
                </div>
              </div>
            </div>
            <div className="panel-body">
              <div className="row">
                <div className="col-xs-6">
                  <h6><strong>Product</strong></h6>
                </div>
                <div className="col-xs-6">
                  <div className="col-xs-4 text-center">
                    <h6><strong>Price</strong></h6>
                  </div>
                  <div className="col-xs-4 text-center">
                    <h6><strong>Quantity</strong></h6>
                  </div>
                  <div className="col-xs-4 text-center">
                    &nbsp;
                  </div>
                </div>
              </div>
              {itemsMapped.length > 0 ? itemsMapped : empty}
            </div>

            <div className="panel-footer">
              <div className="row text-center">
                <div className="col-xs-9">
                  <h4 className="text-right">Total <strong>${this.props.total}</strong></h4>
                </div>
                <div className="col-xs-3">
                  <button type="button" className="btn btn-info btn-sm btn-block" onClick={this.emptyCart} disabled={itemsMapped.length == 0}>
                    Empty cart
                  </button>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    );
  }
});