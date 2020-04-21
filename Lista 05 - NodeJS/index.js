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

app.get('/exer2', (req,res) => {

  res.render(__dirname+'/views/exercicio02.html',{result: ""});
})

app.get('/operacao', (req,res) => {
  var number1 = req.query.number1;
  var number2 = req.query.number2;
  var sub = 0;
  sub = (parseInt(number1)) - (parseInt(number2));
    res.render(__dirname+'/views/exercicio02.html',{result: "Resultado da Subtração de "+number1+" - "+ number2 +" = "+ sub});
})

app.post("/operacao", (req,res)=>{
  var num1 = req.body.number1;
  var num2 = req.body.number2;
  var soma = parseInt(num1) + parseInt(num2)
  
  res.render(__dirname+'/views/exercicio02.html',{result: "Resultado da Soma de "+num1+" + "+num2+" = "+ soma});
})



app.listen(process.env.port || 3000);

console.log('Running at Port 3000');
