const express = require('express');
const app = express();

const path = require('path');
const router = express.Router();
__dirname = path.resolve();


var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: false }));

app.engine('html', require('ejs').renderFile);

app.get('/', (req, res) => {
  res.render(__dirname + '/views/exercicio01.html', { soma: "" });

})

app.post('/soma', (req, res) => {

  var form = req.body.soma;
  
  console.log(req.body);
  var soma = 0;
  for (var i = 0; i < form.length; i++) {
    soma += parseInt(form[i]);
    console.log(form[i])
  }
  console.log(soma)
  res.render(__dirname + '/views/exercicio01.html', { soma: "Resultado: " + soma })
})




app.listen(process.env.port || 3000);

console.log('Running at Port 3000');
