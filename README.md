ScalaJS + Slinky + Mill
=============

Create frontend application with ScalaJS and Slinky.

Features
--------

- Separate build for Scala (Mill) and JavaScript (webpack)
- Sourcemaps
- Fast refresh (persistent state WIP)
- State management with `useReducer` react hook
- MaterialUI bindings
- Automatic deployment to GitHub Pages

The IDEA project can be generated with:
```sh
$ ./mill mill.scalalib.GenIdea/idea
```

Development
-----------

Open two terminals. First will be continously building scala sources. Seconds will be assembling final bundle and serve assets.

Compile scala sources:
```
$ ./mill -w client.compileJs
```

Assemble the bundle and run dev server:
```
$ npm install
$ npm run dev-server
```
