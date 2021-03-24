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
            <a href='/'>Home</a>
          </li>
          <li>
            <a href='/auth/sign-in'>Sign-in</a>
          </li>
          <li>
            <a href='/other'>Other</a>
          </li>
          <li>
            <a href='/backend/api/dummy'>Dummy Service</a>
          </li>
          <li>
            <a href='/auth/api/logout'>Logout</a>
          </li>
        </ul>
      </div>
    )
  }
}
