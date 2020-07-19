const { rootPath } = require("./common");

const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  mode: "development",
  devtool: 'eval-source-map',
  entry: [
    __dirname + '/index.js'
  ],
  resolve: {
    modules: [
      rootPath + '/node_modules',
      rootPath + '/out/client/compileJs/dest'
    ],
    alias: {
      'react-dom': '@hot-loader/react-dom',
    }
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules|out.js/,
        use: 'babel-loader',
      },
      {
        test: /\.js$/,
        enforce: 'pre',
        use: 'source-map-loader',
      },
    ]
  },
  stats: {
    warningsFilter: [/Failed to parse source map/],
  },
  devServer: {
    hot: true,
    watchOptions: {
      poll: 100
    }
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: __dirname + '/index.html',
      templateParameters: {
        config: {
          serverUrl: 'http://localhost:8080'
        }
      }
    })
  ]
};
