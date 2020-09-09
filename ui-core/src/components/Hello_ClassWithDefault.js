export default class Hello_ClassWithDefault {
  helloClassWithDefault = (name = 'World') => {
    console.log(`Hello ${name}`);
  }

  static staticHelloClassWithDefault = (name = 'World') => {
    console.log(`Hello ${name}`);
  }
}
