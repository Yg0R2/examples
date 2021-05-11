import React from 'react'
import ReactDOM from 'react-dom'

import Layout from '@yg0r2/ui-layout'
import '@yg0r2/ui-layout/dist/index.css'

import testImpl from './TestImpl'

testImpl.execute()

ReactDOM.render(<Layout.App />, document.getElementById('layout-root'))
