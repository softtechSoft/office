function logout(){
if(!confirm("ログアウトする")){
return false;
}
window.location.href="/login";
}