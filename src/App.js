import React from 'react';
import './App.css';
import { Component } from 'react';
import axios from 'axios'

class App extends Component{

  state = {
    kryptos: []
  }

  //Crypto Api
  componentDidMount(){
      axios.get('http://localhost:8082//getAllCurrencyInfo')
      .then(res => {
        console.log(res.data)
        this.setState({ kryptos: res.data })
    });
  }

  render(){ 
    return (

      // Table New York Stock Exchange
      <div>
      <div className = "floatLeft">
      <table>
        <thead>
        <tr>
          <th colSpan="4">New York Stock Exchange</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>Cryptocurrency</th>
          <th>Current Value</th>
          <th>Exchange currency</th>
          <th>Action Recommendation</th>
        </tr>
        
        {
          this.state.kryptos.filter(datas => datas.stockExchange === 'NYSE').map((filtered, i)=>{
            return <tr key={i}>
              <td>{filtered.cryptoCurr}</td>
              <td>{filtered.currVal}</td>
              <td>{filtered.currency}</td>
              <td>{filtered.actionRecommended}</td>
            </tr>
          })
        }
      </tbody>
      </table>
      </div>

      {/* Table Bombay Stock Exchange */}
      <div className="floatRight">
      <table>
      <thead>
      <tr>
        <th colSpan="4">Bombay Stock Exchange</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <th>Cryptocurrency</th>
        <th>Current Value</th>
        <th>Exchange currency</th>
        <th>Action Recommendation</th>
      </tr>
      {
          this.state.kryptos.filter(datas => datas.stockExchange === 'BSE').map((filtered, i)=>{
            return <tr key={i}>
              <td>{filtered.cryptoCurr}</td>
              <td>{filtered.currVal}</td>
              <td>{filtered.currency}</td>
              <td>{filtered.actionRecommended}</td>
            </tr>
          })
        }
      </tbody>
    </table>
    </div>
    </div>

    );
    }
}
export default App;