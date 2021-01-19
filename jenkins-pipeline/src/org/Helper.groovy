package org

class Helper extends Script {

    String instanceMethod() {
        return 'instance method'
    }

    @Override
    Object run() {
        return this
    }

    static String staticMethod() {
        return  'static method'
    }

}
