import {Hello_Function, Hello_ArrowFunction, Hello_Class, Hello_ClassInstance, instanceFromHollowClass, helloClassInstanceWithDefault, Hello_ClassInstanceWithDefault} from '@examples/ui-core';
import React from 'react';

import './App.css';

function App() {
  console.log("Hello_Function: ", Hello_Function);
  // Hello_Function.default("Hello_Function");
  Hello_Function.helloFunction("hello?")

  console.log("Hello_ArrowFunction: ", Hello_ArrowFunction);
  Hello_ArrowFunction.helloArrow("Hello_ArrowFunction");

  console.log("Hello_Class: ", Hello_Class);
  const asd = new Hello_Class.HelloClass();
  asd.helloClass("Hello_Class")
  // Hello_Class.default.hello("hihih");
  // Hello_Class.default.staticHello("haha");
  // Hello_Class.staticHelloClass("haha");

  console.log("Hello_ClassInstance", Hello_ClassInstance);
  Hello_ClassInstance.helloClassInstance.helloClassInstance("Hello_ClassInstance");

  console.log("instanceFromHollowClass", instanceFromHollowClass);
  instanceFromHollowClass.helloClassWithDefault("instanceFromHollowClass");

  console.log("helloClassInstanceWithDefault", helloClassInstanceWithDefault);
  helloClassInstanceWithDefault.helloClassInstanceWithDefault("helloClassInstanceWithDefault");
  console.log(Hello_ClassInstanceWithDefault.QWE);

  const app = (
    <div className="App">
      App content
    </div>
  );

  return app;
}

export default App;
