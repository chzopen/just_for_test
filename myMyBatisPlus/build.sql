CREATE TABLE "fx_spot" (
    "id" int8 NOT NULL,
    "currency1" varchar(3) NOT NULL,
    "currency2" varchar(3) NOT NULL,
    "fx_rate" float8 NOT NULL,
    "datetime" timestamp(6) NOT NULL,
    "labels" varchar(1024) ,
    CONSTRAINT "fx_sport_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fx_spot_u_1" UNIQUE ("currency1", "currency2", "datetime")
)
;
