class HelloClassInstance {
  helloClassInstance = (name = 'World') => {
    console.log(`Hello ${name}`);
  }

  static staticHelloClassInstance = (name = 'World') => {
    console.log(`Hello ${name}`);
  }
}

export const helloClassInstance = new HelloClassInstance();
