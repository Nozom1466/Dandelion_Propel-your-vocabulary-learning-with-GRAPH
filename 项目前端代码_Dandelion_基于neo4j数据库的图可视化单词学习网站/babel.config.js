module.exports = {
  presets: ["@vue/cli-plugin-babel/preset"],
  env: {
    node: {
      presets: ["@babel/preset-env"],
    },
    jQuery: {
      plugins: ["jquery"],
    },
  },
};
