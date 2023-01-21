<?php
$user = 'root';
$dbname = 'food_management';
$passwd = 'group7';
$host = 'localhost';
$dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";

$pdo = new PDO($dsn, $user, $passwd);
$pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);



















?>