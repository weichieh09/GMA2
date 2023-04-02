import { IProdCountry } from '@/shared/model/prod-country.model';
import { ICountryStd } from '@/shared/model/country-std.model';
import { ICountryCert } from '@/shared/model/country-cert.model';
import { ICountryMark } from '@/shared/model/country-mark.model';

export interface ICountry {
  id?: number;
  countryNo?: string | null;
  enName?: string | null;
  chName?: string | null;
  prodCountries?: IProdCountry[] | null;
  countryStds?: ICountryStd[] | null;
  countryCerts?: ICountryCert[] | null;
  countryMarks?: ICountryMark[] | null;
}

export class Country implements ICountry {
  constructor(
    public id?: number,
    public countryNo?: string | null,
    public enName?: string | null,
    public chName?: string | null,
    public prodCountries?: IProdCountry[] | null,
    public countryStds?: ICountryStd[] | null,
    public countryCerts?: ICountryCert[] | null,
    public countryMarks?: ICountryMark[] | null
  ) {}
}
