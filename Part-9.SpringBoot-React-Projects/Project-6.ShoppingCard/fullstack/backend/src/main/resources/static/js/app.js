var App = React.createClass({
  getInitialState: function() {
    return { items: [], products: [] };
  },

  componentWillMount: function() {
    this.pusher = new Pusher(
        PUSHER_APP_KEY, {
        cluster: PUSHER_CLUSTER_KEY,
        forceTLS: true
    });

    this.channel = this.pusher.subscribe(PUSHER_CHANNEL_NAME);
    this.total = 0;
  },

  componentDidMount: function() {
    this.channel.bind('itemAdded', this.itemAdded);
    this.channel.bind('itemUpdated', this.itemUpdated);
    this.channel.bind('itemRemoved', this.itemRemoved);
    this.channel.bind('cartEmptied', this.cartEmptied);
    
    fetch('/products').then(function(response) {
        return response.json();
    }).then(this.getProductsSuccess);
    
    fetch('/cart/items', {
    	credentials: 'same-origin',
    }).then(function(response) {
        return response.json();
    }).then(this.getCartItemsSuccess);
  },

  componentWillUnmount: function() {
	// Unbind from channel events
    this.channel.unbind();

    // Unsubscribe from the Pusher channel
    this.pusher.unsubscribe(this.channel);
    
    // Unregister by assign them to an empty function
    this.getProductsSuccess = function() {};
    this.getCartItemsSuccess = function() {};
  },

  itemAdded: function(item) {
    var newArray = this.state.items.slice(0);
    newArray.push(item);
    
    this.countTotal(newArray);

    this.setState({
      items: newArray,
    });
  },

  itemUpdated: function(item) {
    var newArray = this.state.items.slice(0);
    var indexToUpdate;

    this.state.items.some(function(it, index) {
      if(it.id === item.id) {
    	indexToUpdate = index;
        return true;
      }
    });
    
    newArray[indexToUpdate].quantity = item.quantity;
    
    this.countTotal(newArray);

    this.setState({
      items: newArray,
    });
  },

  itemRemoved: function(item) {
    var newArray = this.state.items.slice(0);
    var indexToRemove;

    this.state.items.some(function(it, index) {
      if(it.id === item.id) {
        indexToRemove = index;
        return true;
      }
    });
    
    newArray.splice(indexToRemove, 1);
    
    this.countTotal(newArray);

    this.setState({
      items: newArray,
    });
  },

  cartEmptied: function() {
	var newArray = [];
	this.countTotal(newArray);
	
    this.setState({
      items: newArray
    });
  },
  
  getProductsSuccess: function(response) {
    this.setState({
    	products: response
    });
  },
  
  getCartItemsSuccess: function(response) {
	this.countTotal(response);
	this.setState({
	  items: response
	});
  },
  
  countTotal: function(newArray) {
    var temp = 0;

    newArray.forEach(function(item, index) {
      temp += (item.price * item.quantity);
    });

    this.total = temp;
  },

  render: function() {
    return (
      <div className="container">
        <Header  />
        <Cart items={this.state.items} total={this.total} />
        <ProductList products={this.state.products} />
      </div>
    );
  }
});

ReactDOM.render(<App />, document.getElementById("app"));