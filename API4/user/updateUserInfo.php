<?php
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";


    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $user_id = $_GET["user_id"];
    $user_name = $_GET["user_name"];
    $user_passwd = $_GET["user_passwd"];
    $user_address = $_GET["user_address"];
    $user_mail = $_GET["user_mail"];

    $sql = "update user set user_name = '". $user_name ."', user_passwd = '". $user_passwd ."', user_address = '". $user_address."', user_mail = '". $user_mail ."' whe$
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select user_name, user_passwd, user_address, user_mail from user where user_id = ". $user_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($result, JSON_UNESCAPED_UNICODE);
?>