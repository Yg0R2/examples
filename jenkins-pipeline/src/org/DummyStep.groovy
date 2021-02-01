package org

class DummyStep implements Serializable {

    private def context

    DummyStep(context) {
        this.context = context
    }

    void greet(String greet) {
        println(context)
//        echo("asd")
        context.echo("Hello $greet from DummyStep class!")
    }

}
