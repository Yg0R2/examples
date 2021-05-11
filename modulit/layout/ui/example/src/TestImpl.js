import Layout from '@yg0r2/ui-layout'

class TestImpl extends Layout.Test {
  execute = () => {
    console.log(Layout.Test.VALUE)
    console.log(TestImpl.VALUE)
  }
}

export default new TestImpl()
