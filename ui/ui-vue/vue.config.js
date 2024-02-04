const { defineConfig } = require('@vue/cli-service');
const path = require("path");
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: path.resolve(__dirname, "../../backend-service/src/main/resources/static"),
})
