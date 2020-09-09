import babel from '@rollup/plugin-babel';
import commonjs from "@rollup/plugin-commonjs";
import resolve from '@rollup/plugin-node-resolve';

import pkg from './package.json';

export default {
  input: [
    'src/main.js'
  ],
  output: [{
    dir: 'build',
    // name: 'main.js', // Required for iief format
    // format: 'iife', // NOT working
    // format: 'umd', // It is working
    format: 'cjs', // It is working
    exports: 'named',
    sourcemap: true,
    strict: true
  }],
  plugins: [
    resolve(),
    babel({
      babelHelpers: 'bundled',
      exclude: 'node_modules/**',
      extensions: ['.js', '.jsx'],
      plugins: [
        '@babel/plugin-proposal-class-properties',
        '@babel/plugin-proposal-export-default-from'
      ]
    }),
    commonjs()
  ],
  external: Object.keys(pkg.dependencies)
}
