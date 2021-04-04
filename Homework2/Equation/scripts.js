let a = 'a', b = 'b', c = 'c';
let eq_str = '<p>' + a + 'x<sup>2</sup> + ' + b + 'x + ' + c +' = 0</p>';


let equation = document.createElement('h2');
equation.innerHTML = eq_str;
eq_heap.append(equation);

function checkCoeffA(key)
{
    let inp = ((key >= '0' && key <= '9') || (key == '-') || (key == '.'));
    if ((a == 'a') &&  (inp))
        a = '';
    if (key == 'Backspace')
    {
        a = a.substring(0, a.length - 1)
        if (a == '')
         a = 'a';
    }
    else if (inp){
        if ((a.length >= 6) || ((a.length >= 1) && (key == '-')) ){
            return false;
        }
        a += key;
    }
    eq_str = '<p>' + a + 'x<sup>2</sup> + ' + b + 'x + ' + c +' = 0</p>';
    equation.innerHTML = eq_str;
    return (inp || (key == 'Backspace'));
}

function checkCoeffB(key)
{
    let inp = ((key >= '0' && key <= '9') || (key == '-') || (key == '.'));
    if ((b == 'b') &&  (inp))
        b = '';
    if (key == 'Backspace')
    {
        b = b.substring(0, b.length - 1)
        if (b == '')
         b = 'b';
    }
    else if (inp){
        if ((b.length >= 6) || ((b.length >= 1) && (key == '-'))){
            return false;
        }
        b += key;
    }
    eq_str = '<p>' + a + 'x<sup>2</sup> + ' + b + 'x + ' + c +' = 0</p>';
    equation.innerHTML = eq_str;
    return (inp || (key == 'Backspace'));
}

function checkCoeffC(key)
{
    let inp = ((key >= '0' && key <= '9') || (key == '-') || (key == '.'));
    if ((c == 'c') &&  (inp))
        c = '';
    if (key == 'Backspace')
    {
        c = c.substring(0, c.length - 1)
        if (c == '')
         c = 'c';
    }
    else if (inp){
        if ((c.length >= 6) || ((c.length >= 1) && (key == '-')) ){
            return false;
        }
        c += key;
    }
    eq_str = '<p>' + a + 'x<sup>2</sup> + ' + b + 'x + ' + c +' = 0</p>';
    equation.innerHTML = eq_str;
    return (inp || (key == 'Backspace'));
}

function solve(){
    let x1;
    let x2;
    if (Number(a) == 0) {
        x1 = -Number(c) / Number(b);
        x2 = 'Отсутсвует';
        return [x1, x2];
    }
    let disc = Number(b) * Number(b) - 4.0 * Number(a) * Number(c);
    sqDisc = Math.sqrt(Math.abs(disc));
    if (disc >= 0)
    {
        x1 = (-Number(b) + sqDisc) / (2.0 * Number(a));
        x2 = (-Number(b) - sqDisc) / (2.0 * Number(a));
    }
    else {
        x1 = ((-Number(b)) / (2.0 * Number(a))) + '+' + (sqDisc / (2.0 * Number(a))) + 'i';
        x2 = ((-Number(b)) / (2.0 * Number(a))) + '-' + (sqDisc / (2.0 * Number(a))) + 'i';
    }
    return [x1, x2];
}

function createEquation(){
    let out_eq = '';
    if (Number(a) != 0) {
        out_eq += (a + 'x<sup>2</sup>'); 
    }
    if (Number(b) != 0){
        if (Number(b) > 0){
            out_eq += '+';
        }
        out_eq += (b + 'x');
    }
    if (Number(c) != 0){
        if (Number(c) > 0){
            out_eq += '+';
        }
        out_eq += c;
    }
    if (out_eq == ''){
        out_eq = '0';
    }
    out_eq += ' = 0';
    return out_eq;
}

function setEquation()
{
    if (isNaN((Number(a))) || (isNaN(Number(b))) || (isNaN(Number(c))))
    {
        pResult.innerHTML = "Вы ошиблись в заданных коэффициентах";
        return;
    }
    if ( (Number(a) == 0) && (Number(b) == 0) )
    {
        pResult.innerHTML = "Вы ошиблись в уравнении";
        return;
    }
    let x = solve();
    pResult.innerHTML = "<strong>Решение:</strong> x<sub>1</sub> = " + x[0] + ", x<sub>2</sub> = "+ x[1];
    CreateTr(x[0], x[1]);
}

function CreateTr(x1, x2) {
    let eqTable = document.getElementById("resultEqTable");
    let eqTr = document.createElement('tr');
    eqTr.setAttribute("onclick", "RemoveTr(this)");
    
    let eqTd = document.createElement('td');
    eqTd.innerHTML = createEquation();
    eqTr.appendChild(eqTd);

    let x1Td = document.createElement('td');
    x1Td.innerHTML = x1;
    eqTr.appendChild(x1Td);

    let x2Td = document.createElement('td');
    x2Td.innerHTML = x2;
    eqTr.appendChild(x2Td);
    
    eqTable.appendChild(eqTr);
}

function RemoveTr(tr) {
    tr.remove();
}

