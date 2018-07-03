CREATE TABLE `baza_lekarze` (
  `ID` int(11) NOT NULL,
  `lekarzType` int(11) NOT NULL,
  `agent` varchar(255) DEFAULT NULL,
  `lekarz` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `prezentacje-scoress` (
  `appId` int(11) NOT NULL,
  `lekarzType` int(11) NOT NULL,
  `agent` varchar(255) DEFAULT NULL,
  `lekarz` varchar(255) DEFAULT NULL,
  `serverDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createDate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `prezentacja-trilac-ecomer-antucholesteran` (
  `agent` varchar(255) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `miasto` varchar(255) DEFAULT NULL,
  `instytucja` varchar(255) DEFAULT NULL,
  `timeInApp` varchar(255) DEFAULT NULL,
  `serverDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createDate` varchar(255) DEFAULT NULL,
  `firstChoice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `prezentacja-trilac-plus-ecomer-junior-aquamer` (
  `agent` varchar(255) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `miasto` varchar(255) DEFAULT NULL,
  `instytucja` varchar(255) DEFAULT NULL,
  `timeInApp` varchar(255) DEFAULT NULL,
  `serverDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createDate` varchar(255) DEFAULT NULL,
  `firstChoice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
