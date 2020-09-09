export class HelloClass {
  helloClass = (name = 'World') => {
    console.log(`Hello ${name}`);
  }

  static staticHelloClass = (name = 'World') => {
    console.log(`Hello ${name}`);
  }
}
