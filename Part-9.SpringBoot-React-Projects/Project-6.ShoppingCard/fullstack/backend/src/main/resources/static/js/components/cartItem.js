var CartItem = React.createClass({
  deleteItem: function() {
    fetch('/cart/item', {
      credentials: 'same-origin',
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        id: this.props.item.id,
     })
    });
  },

  render: function() {
    var name = this.props.item.name;
    var id = this.props.item.id;
    var price = this.props.item.price;
    var quantity = this.props.item.quantity;

    return (
      <div className="row cart-item">
        <div className="col-xs-6">
          <h6 className="product-name"><strong>{name}</strong></h6>
        </div>
        <div className="col-xs-6">
          <div className="col-xs-4 text-center">
            <h6>{price}</h6>
          </div>
          <div className="col-xs-4 text-center">
            <h6>{quantity}</h6>
          </div>
          <div className="col-xs-4 text-center">
            <button type="button" className="btn btn-link btn-xs" onClick={this.deleteItem}>
              <i className="fa fa-trash-o fa-lg"></i>
            </button>
          </div>
        </div>
      </div>
    );
  }
});