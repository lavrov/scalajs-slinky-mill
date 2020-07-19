const { rootPath } = require("./common");
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  mode: "production",
  entry: [
    __dirname + '/index.js'
  ],
  resolve: {
    extensions: ['.js'],
    modules: [
      rootPath + '/node_modules',
      rootPath + '/out/client/fullOpt/dest'
    ]
  },
  module: {
    rules: [
      {
        exclude: /node_modules|out.js/,
        test: /\.js$/,
        use: 'babel-loader',
      }
    ]
  },
  output: {
    path: rootPath + '/out/client/webpack/prod',
    filename: 'bundle.js'
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: __dirname + '/index.html',
      templateParameters: {
        config: {
          serverUrl: 'https://exmaple.prod'
        }
      }
    })
  ]
};
