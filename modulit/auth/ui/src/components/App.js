import React from 'react'

export default class App extends React.Component {

  render() {
    return (
      <form method="POST" action="/auth/api/login">
        <h2>Log in</h2>

        <div>
          <label>
            User name:
            <input
              name="userName"
              type="text"
              placeholder="Username"
              autoFocus
            />
          </label>
          <label>
            Password:
            <input
              name="password"
              type="password"
              placeholder="Password"
            />
          </label>
          <button type="submit">Log In</button>
        </div>
      </form>
    )
  }

}
