<?php
    //ユーザ検索

    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

    //データベース接続
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $user_mail = $_GET["user_mail"];

    //SQL実行
    $sql = "select user_id, user_name from user where user_mail = '". $user_mail ."'";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($result, JSON_UNESCAPED_UNICODE);
?>