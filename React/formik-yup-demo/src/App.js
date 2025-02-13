import './App.css';
import Product from './components/Product';
import Signup from './components/Signup';

function App() {
  return (
    <div className="App">
      <div class="row">
        <div class="col-sm-4">
          One
        </div>
        <div class="col-sm-4">
          <Product/>
        </div>
        <div class="col-sm-4">
          <Signup />
        </div>
      </div>
    </div>
  );
}

export default App;
