---危险物料---{{{1
SELECT *
FROM WOSAFETYLINK
WHERE EXISTS
  (SELECT *
  FROM workorder
  WHERE wonum = workorder.wonum
  AND EXISTS
    (SELECT *
    FROM wohazard
    WHERE wonum            = workorder.wonum
    AND hazardid           = wosafetylink.hazardid
    AND wosafetydatasource = wosafetylink.wosafetydatasource
    AND hazmatenabled      = 1
    AND siteid             =workorder.siteid
    )
  AND siteid=workorder.siteid
  )


---锁定/标定---{{{1
SELECT *
FROM WOSAFETYLINK
WHERE EXISTS
  (SELECT *
  FROM workorder
  WHERE wonum   = workorder.wonum
  AND tagoutid IS NULL
  AND EXISTS
    (SELECT *
    FROM wohazard
    WHERE wonum            = workorder.wonum
    AND hazardid           = wosafetylink.hazardid
    AND wosafetydatasource = wosafetylink.wosafetydatasource
    AND tagoutenabled      = 1
    AND siteid             =workorder.siteid
    )
  AND WOSAFETYLINK.siteid=workorder.siteid
  )
