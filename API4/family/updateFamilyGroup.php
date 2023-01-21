<?php
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";


    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $family_id = $_GET["family_id"];
    $family_name = $_GET["family_name"];

    $sql = "update family set family_name = '". $family_name ."' where family_id = ". $family_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select family_name from family where family_id = ". $family_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($result, JSON_UNESCAPED_UNICODE);
?>