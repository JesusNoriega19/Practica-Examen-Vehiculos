SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_vehiculo` (IN `p_id` INT)   BEGIN
    SELECT * FROM vehiculos WHERE ID = p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_vehiculos` ()   BEGIN
    SELECT * FROM vehiculos;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_vehiculo` (IN `p_id` INT, IN `p_vin` VARCHAR(17), IN `p_placa` VARCHAR(10), IN `p_modelo` VARCHAR(50), IN `p_estatus` VARCHAR(20))   BEGIN
    UPDATE vehiculos
    SET VIN = p_vin,
        placa = p_placa,
        modelo = p_modelo,
        estatus = p_estatus
    WHERE ID = p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_vehiculo` (IN `p_id` INT)   BEGIN
    DELETE FROM vehiculos WHERE ID = p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_vehiculo` (IN `p_vin` VARCHAR(17), IN `p_placa` VARCHAR(10), IN `p_modelo` VARCHAR(50), IN `p_estatus` VARCHAR(20))   BEGIN
    INSERT INTO vehiculos (VIN, placa, modelo, estatus)
    VALUES (p_vin, p_placa, p_modelo, p_estatus);
END$$

DELIMITER ;

CREATE TABLE `vehiculos` (
  `ID` int(11) NOT NULL,
  `VIN` varchar(17) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `vehiculos` (`ID`, `VIN`, `placa`, `modelo`, `estatus`) VALUES
(9, '2FTHX26G2KC123456', 'DEF-5678', 'Ford F-150 2019', 'Inactivo'),
(10, '3GNEK18R5LG456789', 'GHI-9101', 'Chevrolet Tahoe 2021', 'Activo'),
(11, '4T1BF1FK7HU223344', 'JKL-2345', 'Toyota Camry 2018', 'En Mantenimiento'),
(12, '5YJSA1E26GF168539', 'MNO-6789', 'Tesla Model S 2022', 'Activo');


ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `vehiculos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
