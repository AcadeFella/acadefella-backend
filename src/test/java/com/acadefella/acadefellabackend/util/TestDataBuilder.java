package com.acadefella.acadefellabackend.util;

import com.acadefella.acadefellabackend.domain.student.command.CreateStudent;
import com.acadefella.acadefellabackend.domain.student.core.StudentState;
import com.acadefella.acadefellabackend.domain.student.core.value.*;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.RollNo;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Section;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Standard;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.*;
import com.github.javafaker.Faker;

public class TestDataBuilder {
  private static final Randomizer randomizer = Randomizer.create();
  private static final Faker faker = Randomizer.create().getFaker();

  public static StudentState.StudentStateBuilder randomStudentStateBuilder() {
    var name = Name.create(faker.name().name());
    return StudentState.builder()
        .name(name)
        .userName(UserName.create(faker.name().name()))
        .password(Password.create(faker.random().hex()))
        .personalDetails(randomPersonalDetailsBuilder().build())
        .academicDetails(randomAcademicDetailsBuilder().build());
  }

  public static CreateStudent.CreateStudentBuilder randomCreateStudentBuilder() {
    return CreateStudent.builder()
        .name(Name.create(faker.name().name()))
        .userName(UserName.create(faker.name().name()))
        .password(Password.create(faker.random().hex()))
        .personalDetails(randomPersonalDetailsBuilder().build())
        .academicDetails(randomAcademicDetailsBuilder().build());
  }

  private static PersonalDetails.PersonalDetailsBuilder randomPersonalDetailsBuilder() {
    var name = Name.create(faker.name().name());
    return PersonalDetails.builder()
        .name(name)
        .fatherName(FatherName.create(faker.name().name()))
        .motherName(MotherName.create(faker.name().name()))
        .address(randomAddressBuilder().build());
  }

  private static AcademicDetails.AcademicDetailsBuilder randomAcademicDetailsBuilder() {
    return AcademicDetails.builder()
        .section(Section.create("A"))
        .rollNo(RollNo.create(randomizer.nextInt().toString()))
        .standard(Standard.create(randomizer.standard()))
        .schoolName(SchoolName.create(faker.funnyName().name()));
  }

  private static Address.AddressBuilder randomAddressBuilder() {
    return Address.builder()
        .city(City.create(faker.address().city()))
        .houseNumber(HouseNumber.create(faker.address().buildingNumber()))
        .pin(Pin.create(faker.address().zipCode()))
        .landMark(LandMark.create(faker.address().secondaryAddress()))
        .state(State.create(faker.address().state()))
        .street(Street.create(faker.address().streetAddress()));
  }
}
