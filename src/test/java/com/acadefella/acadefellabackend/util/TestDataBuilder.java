package com.acadefella.acadefellabackend.util;

import com.acadefella.acadefellabackend.message.StudentMessage;
import com.acadefella.acadefellabackend.student.domain.command.CreateStudent;
import com.acadefella.acadefellabackend.student.domain.core.StudentState;
import com.acadefella.acadefellabackend.student.domain.core.value.*;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.RollNo;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.Section;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.Standard;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.*;
import com.github.javafaker.Faker;
import java.time.Instant;

public class TestDataBuilder {
  private static final Randomizer randomizer = Randomizer.create();
  private static final Faker faker = Randomizer.create().getFaker();

  public static StudentState.StudentStateBuilder randomStudentStateBuilder() {
    var name = Name.create(faker.name().name());
    return StudentState.builder()
        .name(name)
        .email(Email.create(faker.name().name()))
        .password(Password.create(faker.random().hex()))
        .personalDetails(randomPersonalDetailsBuilder().build())
        .academicDetails(randomAcademicDetailsBuilder().build());
  }

  public static CreateStudent.CreateStudentBuilder randomCreateStudentBuilder() {
    return CreateStudent.builder()
        .name(Name.create(faker.name().name()))
        .email(Email.create(faker.name().name()))
        .phoneNumber(PhoneNumber.create(faker.phoneNumber().phoneNumber()))
        .dob(Instant.now())
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

  public static StudentMessage.StudentMessageBuilder randomStudentMessageBuilder() {
    return StudentMessage.builder()
        .name(faker.name().name())
        .email("email@fake.in")
        .phoneNumber(faker.phoneNumber().phoneNumber())
        .password("fakePass")
        .dob(Instant.now());
  }
}
