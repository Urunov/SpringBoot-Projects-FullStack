function validate() {
    let name = document.getElementById("name").value();

    if (name == '') {
    alert('Please enter a valid name.');
        return false;
    } else {
          return true;
      }
    }