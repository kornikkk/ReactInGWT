const path = require("path");
const paths = require('./node_modules/react-scripts/config/paths');
paths.appHtml = path.resolve(path.join(__dirname, '../..', 'main/public/index.html'));

module.exports = {
};