<?php
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

    //データベース接続
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $reception_user_id = $_GET["user_id"];
    $family_id = $_GET["family_id"];

    //SQL実行
        $sql = "update user set family_id = ". $family_id ." where user_id = ". $reception_user_id ."";
        $stm = $pdo->prepare($sql);
        $stm->execute();

        $sql = "select family_id from family where family_id = ". $family_id ."";
        $stm = $pdo->prepare($sql);
        $stm->execute();
        $result = $stm->fetch(PDO::FETCH_ASSOC);
        echo json_encode($result, JSON_UNESCAPED_UNICODE);
?>