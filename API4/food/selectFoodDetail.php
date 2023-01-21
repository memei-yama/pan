<?php
    //食品の詳細情報を取得
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

    //引数受け取り
    $food_id = $_GET["food_id"];

    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $sql = "select * from food where food_id = ". $food_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($result, JSON_PRETTY_PRINT);
?>