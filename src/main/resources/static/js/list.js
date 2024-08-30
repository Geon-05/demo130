window.addEventListener("load",function(){
  go;
  insert_book();
})

let insert_book = function(){
  let btn_insert_book = document.querySelector('#btn_insert_book');
  
  btn_insert_book.addEventListener('click',function(){
    location.href='/book/bookInsert';
  })
}

let go = function go(pageNo){
  location.href="/book/bookList?pageNo="+pageNo;
}