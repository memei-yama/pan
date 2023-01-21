<?php
    //パスワードが一致するか確認し、ログインさせる

    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

    //データベース接続
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $user_id = $_GET["user_id"];
    $password = $_GET["user_passwd"];

    //SQL実行
    $sql = "select user_passwd from user where user_id = ". $user_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result2 = $stm->fetch(PDO::FETCH_ASSOC);
    $passwd =  $result2['user_passwd'];

    if($password == $passwd){
        $result = 1;
    }else{
        $result = 0;
    }
    return $result;
    //return json_encode($result2, JSON_UNESCAPED_UNICODE);
?>