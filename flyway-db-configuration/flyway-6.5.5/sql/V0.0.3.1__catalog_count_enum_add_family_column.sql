
 update catalog_count_enum set family = "tithes" where identifier = ('1.1');
 update catalog_count_enum set family = "donations" where identifier = ('1.2');
 update catalog_count_enum set family = "offerings" where identifier = ('1.3');
 update catalog_count_enum set family = "services" where identifier like ('2.%');
 update catalog_count_enum set family = "helps" where identifier like ('3.%');
 update catalog_count_enum set family = "general" where identifier like ('4.%');
 update catalog_count_enum set family = "food" where identifier like ('5.%');
 update catalog_count_enum set family = "traveling" where identifier like ('6.%');
 update catalog_count_enum set family = "stationary" where identifier like ('7.%');
 update catalog_count_enum set family = "immovables" where identifier like ('8.%');
 update catalog_count_enum set family = "fees" where identifier like ('9.%');
