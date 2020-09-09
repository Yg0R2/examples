export const ASD = "asdValue";

export class Hello_ClassInstanceWithDefault {
  static get QWE() {
    return "qweValue";
  }

  helloClassInstanceWithDefault = (name = 'World') => {
    console.log(`Hello ${name}`);
  }

  static staticHelloClassInstanceWithDefault = (name = 'World') => {
    console.log(`Hello ${name}`);
  }
}

// const helloClassInstanceWithDefault = new Hello_ClassInstanceWithDefault();
// export default helloClassInstanceWithDefault;
export default new Hello_ClassInstanceWithDefault();
