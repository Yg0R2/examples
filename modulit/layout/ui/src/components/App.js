import Core from '@yg0r2/ui-core'

import axios from 'axios'
import React from 'react'

export default class App extends React.Component {

  componentDidMount() {
    axios.get('/auth/')
      .then(response => console.log("Response: ", response.data))
      .catch(error => console.log("Error: ", error))
  }

  render() {
    return (
      <div>
        <Core.ExampleComponent text={this.props.userName} />

        <ul>
          <li>
            <a href='http://layout-service/'>Home</a>
          </li>
          <li>
            <a href='http://auth-service/sign-in'>Sign-in</a>
          </li>
          <li>
            <a href='http://layout-service/other'>Other</a>
          </li>
          <li>
            <a href='http://backend-service/api/dummy'>Dummy Service</a>
          </li>
          <li>
            <a href='http://auth-service/api/logout'>Logout</a>
          </li>
        </ul>
      </div>
    )
  }
}
